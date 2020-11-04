package com.lung.game.web.bean;

import lombok.Data;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/4 - 12:14
 * @implSpec
 */
@Data
public class Response {

    private Meta meta;
    private String message;

    public Response() {
    }

    public Response(Meta meta, String message) {
        this.meta = meta;
        this.message = message;
    }

    @Data
    public static class Meta {
        private Object data;
        private int code;

        public Meta(Object data, int code) {
            this.data = data;
            this.code = code;
        }

        public Meta(int code) {
            this.code = code;
        }
    }

    public Response success() {
        this.meta = new Meta(200);
        return new Response(meta, "OK");
    }

    public Response success(Object data) {
        this.meta = new Meta(data, 200);
        return new Response(meta, "OK");
    }

    public Response failure(int code) {
        this.meta = new Meta(code);
        return new Response(meta, "Failure");
    }

}
