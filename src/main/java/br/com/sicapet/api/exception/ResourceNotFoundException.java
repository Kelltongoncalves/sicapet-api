package br.com.sicapet.api.exception;
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){ super(message); }
}
