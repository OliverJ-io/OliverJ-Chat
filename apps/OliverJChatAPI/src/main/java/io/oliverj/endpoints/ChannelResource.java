package io.oliverj.endpoints;

import com.google.gson.Gson;
import io.oliverj.models.ChannelEntity;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/channel/{channel_id}")
public class ChannelResource {

    @Inject
    EntityManagerFactory emf;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String channel(@PathParam("channel_id") Long channel_id) {
        ChannelEntity ce = ChannelEntity.findById(channel_id);

        return String.format("{id: %d, name: \"%s\", icon: \"%s\", type: \"%s\", description: \"%s\"}", ce.id, ce.name, ce.icon, ce.type, ce.description);
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete_channel(@PathParam("channel_id") Long channel_id) {
        EntityManager em = emf.createEntityManager();

        ChannelEntity ce = ChannelEntity.findById(channel_id);

        em.getTransaction().begin();
        ce.delete();
        em.getTransaction().commit();

        return String.format("{id: %d, name: \"%s\", icon: \"%s\", type: \"%s\", description: \"%s\"}", ce.id, ce.name, ce.icon, ce.type, ce.description);
    }
}
