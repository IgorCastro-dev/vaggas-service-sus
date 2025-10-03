package org.sus.infrastructure.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.sus.domain.unidadeinfo.model.UnidadeInfo;

@RegisterRestClient(baseUri = "local/8080")
@Path("/unidade")
public interface UnidadeInfoClient {

    @GET
    @Path("/{id}")
    UnidadeInfo buscaUnidadeInfo(@PathParam("id") Long unidadeId);
}
