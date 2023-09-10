package org.necsus.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.necsus.entities.Costumer;
import org.necsus.repositories.CostumerRepository;

import java.util.List;

@Path("/costumer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CostumerAPI {

    @Inject
    CostumerRepository costumerRepository;

    @GET
    public List<Costumer> list(){
        return costumerRepository.listCostumer();
    }

    @POST
    public Response add(Costumer costumer){
        costumerRepository.createdCostumer(costumer);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(Costumer costumer){
        costumerRepository.deletedCostumer(costumer);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public void updateCostumer(@PathParam("id") Long id, Costumer costumer) {
        costumer.setId(id);
        costumerRepository.updateCostumer(costumer);
    }

}
