import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * For every POST request there should be a @ResponseBody enabling server to send confirmation to client stating either the 
 * request has been received or some error occurred
 * In the below example when the client sends (POSTs) a name, server receives it in JSON ('consumes' states that it takes JSON 
 * which means the request (In this case 'name') is converted to JSON (@RequestBody is used to convert incoming 'name' from 
 * JSON format to String format) and sends JSON ('produces' JSON) to client.
 * @ResponseBody converts "Hello "+name to JSON response ('produces' JSON)
 *
 */
@RequestMapping("/hello")
@Controller
@EnableAutoConfiguration
public class HelloController {
	public String hello(){
		return "Hello World!!";
	}
	@RequestMapping(value="",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String greetings(@RequestBody String name){
		return "Hello "+name;
	}
	public static void main(String[] args) {
		SpringApplication.run(HelloController.class, args);
	}
	
}
