package com.github.enesusta.redis;

public class RedisConfiguration {

    private String host;
    private String password;
    private int port;
    private int timeout;

    public RedisConfiguration(final Builder builder) {
        this.host = builder.host;
        this.password = builder.password;
        this.port = builder.port;
        this.timeout = builder.timeout;
    }

    public static class Builder {

        private String host = "localhost";
        private String password;
        private int port = 6379; // Default port of Redis
        private int timeout = 2000; // default value

        public Builder(final String password) {
            this.password = password;
        }

        public Builder host(final String host) {
            this.host = host;
            return this;
        }

        public Builder port(final int port) {
            this.port = port;
            return this;
        }

        public Builder timeout(final int timeout) {
            this.timeout = timeout;
            return this;
        }

        public RedisConfiguration build() {
            return new RedisConfiguration(this);
        }

    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public int getTimeout() {
        return timeout;
    }
}
