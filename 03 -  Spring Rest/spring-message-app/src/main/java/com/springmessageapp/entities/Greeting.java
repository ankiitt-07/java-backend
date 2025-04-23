package com.springmessageapp.entities;

    import java.util.concurrent.atomic.AtomicLong;

    import lombok.Getter;
    import lombok.Setter;

    @Getter
    @Setter
    public class Greeting {
        private final static AtomicLong counter = new AtomicLong();
        private long id;
        private String message;

        public Greeting(String message) {
            this.id = counter.incrementAndGet();
            this.message = message;
        }

    }

