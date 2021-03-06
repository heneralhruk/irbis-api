package ua.edu.kneu.irbisapi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.arsmagna.IrbisConnection;

import java.io.IOException;

@Component
public class ConnectionKeeper {
    private final IrbisConnection connection;

    public ConnectionKeeper(IrbisConnection connection) {
        this.connection = connection;
    }

    @Scheduled(fixedDelay = 900000)
    public void keepConnected() {
        try {
            connection.noOp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
