package uladzislau.epam.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import uladzislau.epam.model.Employee;

import java.io.IOException;

@Service
public class EmployeeService {
    private static final String BASE_URL_CLEAR = "http://localhost:9200/";
    private static final String BASE_URL = "http://localhost:9200/employees/_doc/";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String getAllEmployees() throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(BASE_URL_CLEAR + "employees/_search");
            httpGet.setHeader("Content-Type", "application/json");
            return httpClient.execute(httpGet, response -> EntityUtils.toString(response.getEntity()));
        }
    }

    public String getEmployeeById(String id) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(BASE_URL + id);
            return httpClient.execute(httpGet, response -> EntityUtils.toString(response.getEntity()));
        }
    }

    public String createEmployee(String id, Employee employee) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(BASE_URL + id);
            String json = objectMapper.writeValueAsString(employee);
            HttpEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/json");

            return httpClient.execute(httpPost, response -> EntityUtils.toString(response.getEntity()));
        }
    }

    public String deleteEmployee(String id) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete(BASE_URL + id);
            return httpClient.execute(httpDelete, response -> EntityUtils.toString(response.getEntity()));
        }
    }

    public String searchEmployees(String field, String value) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String jsonQuery = String.format("{\"query\": {\"term\": {\"%s\": \"%s\"}}}", field, value);
            HttpPost httpPost = new HttpPost(BASE_URL_CLEAR + "employees/_search");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(jsonQuery));
            return httpClient.execute(httpPost, response -> EntityUtils.toString(response.getEntity()));
        }
    }
}