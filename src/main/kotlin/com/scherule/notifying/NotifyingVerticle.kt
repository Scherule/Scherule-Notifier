package com.scherule.notifying;

import io.vertx.core.AbstractVerticle;

class NotifyingVerticle : AbstractVerticle() {

    override fun start() {
        vertx.createHttpServer()
                .requestHandler({
                    it.response().end("Hello Vert.x!")
                })
        .listen(8080);
    }

}