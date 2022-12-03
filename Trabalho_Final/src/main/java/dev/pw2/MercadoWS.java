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

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.pw2.model.Mercado;

@Path("/message")
@Transactional
public class MercadoWS {

   @GET
   @Path("/save/{text}/{idUser}")
   @Produces(MediaType.APPLICATION_JSON)
   public Mercado save(@PathParam("text") String text) {

      Mercado mercado = new Mercado();
      mercado.setText(text);
      mercado.persistAndFlush();

      return mercado;
   }

}