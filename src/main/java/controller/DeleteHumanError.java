package controller;

import human.Human;
import org.springframework.http.HttpStatus;

import java.util.List;

public class DeleteHumanError {
    private HttpStatus status;
    public String message;
    public List<Human> errors;

    public DeleteHumanError(HttpStatus status, String message, List<Human> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
