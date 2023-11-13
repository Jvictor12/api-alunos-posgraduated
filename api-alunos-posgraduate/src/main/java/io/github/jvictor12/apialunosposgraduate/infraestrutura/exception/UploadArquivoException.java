package io.github.jvictor12.apialunosposgraduate.infraestrutura.exception;

public class UploadArquivoException extends RuntimeException{

    public UploadArquivoException() {
        super();
    }

    public UploadArquivoException(String message) {
        super(message);
    }

    public UploadArquivoException(String message, Throwable cause) {
        super(message, cause);
    }
}
