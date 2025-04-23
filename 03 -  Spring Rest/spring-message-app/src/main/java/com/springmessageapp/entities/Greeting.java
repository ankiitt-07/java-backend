package com.springmessageapp.entities;

    import lombok.Getter;
    import lombok.Setter;

    @Getter
    @Setter
    public class Greeting {
        private long id;
        private String message;

        public Greeting(long id, String message) {
            this.id = id;
            this.message = message;
        }

    }

