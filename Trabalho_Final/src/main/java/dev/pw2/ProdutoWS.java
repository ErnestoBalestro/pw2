/**
 * PW2 by Rodrigo Prestes Machado
 *
 * PW2 is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 *
*/
package dev.pw2;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.pw2.model.Produto;

//Serviços

@Path("/channel")
@Transactional
public class ProdutoWS {

   @GET
   @Path("/save/{hash}")
   @Produces(MediaType.APPLICATION_JSON)
   public Produto save(@PathParam("hash") String hash) {
      Produto produto = new Produto();
      produto.setHash(hash);
      produto.persist();
      return produto;
   }

   @GET
   @Path("/add/{idProduto}")
   @Produces(MediaType.APPLICATION_JSON)
   public Long add(@PathParam("idProduto") Long idProduto) {

      Produto produto = Produto.findById(idProduto);
      if (produto == null)
         throw new BadRequestException("Produto não encontrado");

      return idProduto;
   }

   @GET
   @Path("/add/{nome}")
   @Produces(MediaType.APPLICATION_JSON)
   public String add(@PathParam("nome") String nome) {

      if (nome == null)
         throw new BadRequestException("Nome não encontrado");

      return nome;
   }

   @GET
   @Path("/add/{preco}")
   @Produces(MediaType.APPLICATION_JSON)
   public Double add(@PathParam("preco") Double preco) {

      if (preco == null)
         throw new BadRequestException("Preco não encontrado");

      return preco;
   }

   @GET
   @Path("/list")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Produto> list() {
      return Produto.listAll();
   }

}