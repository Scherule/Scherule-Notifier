package com.scherule.notifying;

import io.vertx.core.AbstractVerticle;
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.servicediscovery.ServiceDiscoveryOptions

class NotifyingVerticle : AbstractVerticle() {

    override fun start() {
        val discovery = ServiceDiscovery.create(vertx,
                ServiceDiscoveryOptions()
                        .setAnnounceAddress("scherule-announcing")
                        .setName("notifying"))

        vertx.createHttpServer()
                .requestHandler({
                    it.response().end("Hello Vert.x!")
                })
                .listen(config().getInteger("http.port", 8081), {
                    if (it.succeeded()) {
                        System.out.println("Server started");
                    } else {
                        System.out.println("Cannot start the server: " + it.cause());
                    }
                })

        discovery.close()
    }

}