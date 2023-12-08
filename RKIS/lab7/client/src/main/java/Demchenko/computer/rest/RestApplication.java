package Demchenko.computer.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Запускает клиентскую часть приложения
 */
@SpringBootApplication
public class RestApplication {

    private RestTemplate restTemplate;

    /**
     * Точка входа в приложение
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    /**
     * Шаблон для работы с REST API
     * @return REST шаблон
     */
    @Bean
    public RestTemplate restTemplate() {
        this.restTemplate = new RestTemplate();
        return this.restTemplate;
    }

    /**
     * Получает все компьютеры от сервера
     */
    public void createGetRequest(){
        String url = "http://localhost:8080/api/computer";
        ResponseEntity<Computer[]> response = restTemplate.getForEntity(url, Computer[].class);
        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response headers:");
        System.out.println(response.getHeaders());
        // Get the array of Computer objects from the response
        Computer[] computerArray = response.getBody();
        System.out.println("Response body:");
        // Print each Computer object
        if (computerArray != null) {
            for (Computer computer : computerArray) {
                System.out.println(computer);
            }
        }
    }

    /**
     * Получает компьютера от сервера по индексу
     * @param id индекс запрашиваемого предмета одежды
     */
    public void createGetByIDRequest(Integer id){
        String url = "http://localhost:8080/api/computer/" + id;
        // Send the request
        try {
            ResponseEntity<Computer> response = restTemplate.getForEntity(url, Computer.class);
            System.out.println("Response Code: " + response.getStatusCode());
            System.out.println("Response headers:");
            System.out.println(response.getHeaders());
            System.out.println("Response body:");
            System.out.println(response.getBody());
        }
        catch (HttpClientErrorException e) {
            System.out.println("Response Code: " + e.getStatusCode());
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                System.out.println("Computer with id " + id + " not found");
            } else {
                throw e;  // rethrow the exception if it's not a 404 error
            }
        }
    }

    /**
     * Отправляет предмет одежды на сервер
     * @param computer новый предмет одежды
     */
    public void createPostRequest(Computer computer){
        String url = "http://localhost:8080/api";
        ObjectMapper mapper = new ObjectMapper();
        try{
            String computerJson = mapper.writeValueAsString(computer);
            // Set the headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            // Create a new HttpEntity
            HttpEntity<String> entity = new HttpEntity<>(computerJson, headers);
            // Send the request
            ResponseEntity<Computer> response = restTemplate.postForEntity(url, entity, Computer.class);
            System.out.println("Response Status : " + response.getStatusCode());
            System.out.println("Response headers:");
            System.out.println(response.getHeaders());
            System.out.println("Response Body\n" + response.getBody());
        }
        catch (JsonProcessingException e){
            System.out.println("Impossible to process json file");
        }
    }

    /**
     * Отправляет модифиццированный предмет одеждыы на сервер
     * @param id индекс заменяемого прндмета одежды
     * @param computer изменённый предмет одежды
     */
    public void createPutRequest(Integer id, Computer computer){
        String url = "http://localhost:8080/api/" + computer.getId();
        ObjectMapper mapper = new ObjectMapper();
        try{
            String computerJson = mapper.writeValueAsString(computer);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            // Create a new HttpEntity
            HttpEntity<String> entity = new HttpEntity<>(computerJson, headers);
            try{
                restTemplate.put(url, entity);
                System.out.println("Successfully edited an object\n" + computer);
            }
            catch (HttpClientErrorException e) {
                if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                    System.out.println("Computer with id " + id + " not found");
                } else {
                    throw e;  // rethrow the exception if it's not a 404 error
                }
            }
        }
        catch(JsonProcessingException e){
            System.out.println("Impossible to process json file");
        }
    }

    /**
     * Запрашивает удаление предмета одежды на сервере
     * @param id индекс удаляемого предмета одежды
     */
    public void createDeleteRequest(Integer id){
        try {
            // Send the request
            restTemplate.delete("http://localhost:8080/api/delete/" + id);

            System.out.println("Computer with id " + id + " deleted successfully");
        } catch (HttpClientErrorException e) {
            // Handle the exception
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                System.out.println("Computer with id " + id + " not found");
            } else {
                throw e;  // rethrow the exception if it's not a 404 error
            }
        }
    }

    /**
     * Запускает работу приложения в коммандной строке
     * @return CommandLineRunner
     */
    @Bean
    public CommandLineRunner run() {
        return args -> {
            System.out.println("\n------------------------------ Getting all computers ------------------------------");
            createGetRequest();
            System.out.println("\n--------------------------- Getting computers by its ID ---------------------------");
            createGetByIDRequest(1);
            System.out.println("\n--------------------------- Posting new computer item ---------------------------");
            Computer newComputer = new Computer("Geforce GTX 1660 Ti", "i5-10600f", "LG", 8, 15000);
            createPostRequest(newComputer);
            System.out.println("\n--------------------------- Editing computer by its ID ---------------------------");
            Computer computer = new Computer("RTX 3060 Ti", "i5-10600k", "LOC", 16, 30000);
            int id = 1;
            computer.setId(id);
            createPutRequest(id, computer);
            System.out.println("\n--------------------------- Deleting computer by its ID ---------------------------");
            createDeleteRequest(2);
        };
    }
}
