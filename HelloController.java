import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	
public class HelloController implements Serializable{
	
	@RequestMapping(value="/hello" ,method={"RequestMethod.GET"})
	public String helloPage(){
		return "sample"
	}
	
	@RequestMapping(value="/hello", method={"RequestMethod.POST"})
	public String hello(@RequestParam String name, Model model){
		model.addAllAttributes("name", name);
		return "hello";
	}

}
