package dev.ifrs.Services;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dev.ifrs.entity.Channel;

@Path("/channel")
@Transactional
public class ChannelService {
    
    @GET
    @Path("/add/{hash}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Channel addChannel(@PathParam("hash") String hash){

        Channel channel = new Channel();
        channel.setHash(hash);
        channel.persist();
        return channel;

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Channel> listChannel(){
        return Channel.listAll();
    }


}
