package Api;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class ApiClient {

    public static String post(String urlStr, String params) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            os.write(params.getBytes());
            os.flush();
            os.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static String uploadFile(String urlStr, File file) {
        String boundary = "===" + System.currentTimeMillis() + "===";
        String lineEnd = "\r\n";
        String twoHyphens = "--";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            try (OutputStream os = con.getOutputStream();
                 PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true)) {
                
                // Form field for file
                writer.append(twoHyphens).append(boundary).append(lineEnd);
                writer.append("Content-Disposition: form-data; name=\"imagen\"; filename=\"").append(file.getName()).append("\"").append(lineEnd);
                
                String contentType = java.nio.file.Files.probeContentType(file.toPath());
                if (contentType == null) contentType = "application/octet-stream";
                writer.append("Content-Type: ").append(contentType).append(lineEnd);
                writer.append(lineEnd).flush();

                Files.copy(file.toPath(), os);
                os.flush();

                writer.append(lineEnd);
                writer.append(twoHyphens).append(boundary).append(twoHyphens).append(lineEnd).flush();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}