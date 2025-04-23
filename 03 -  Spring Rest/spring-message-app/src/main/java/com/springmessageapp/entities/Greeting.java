package com.springmessageapp.entities;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.Id;
    import lombok.Builder;

    import lombok.Getter;
    import lombok.Setter;

    @Getter
    @Setter
    @Entity
    @Builder

    public class Greeting {
        @Id
        @GeneratedValue
        private long id;
        private String message;

        public Greeting() {}

        public Greeting(String message) {
            this.message = message;
        }

    }

