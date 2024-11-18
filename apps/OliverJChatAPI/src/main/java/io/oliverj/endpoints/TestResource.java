package io.oliverj.endpoints;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.oliverj.models.ChannelEntity;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Path("/test/channel")
public class TestResource {

    @Inject
    EntityManagerFactory emf;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test_channel() {
        EntityManager entityManager = emf.createEntityManager();

        ChannelEntity ce = new ChannelEntity();
        ce.description = "A Test Channel";
        ce.name = "Test Channel";
        ce.icon = "https://chat.oliverj.io/api/v1/icon/test-channel.png";
        ce.type = ChannelEntity.ChannelType.TEXT;

        entityManager.getTransaction().begin();
        entityManager.persist(ce);
        entityManager.getTransaction().commit();

        return String.format("{id: %d, name: \"%s\", icon: \"%s\", type: \"%s\", description: \"%s\"}", ce.id, ce.name, ce.icon, ce.type, ce.description);
    }
}
