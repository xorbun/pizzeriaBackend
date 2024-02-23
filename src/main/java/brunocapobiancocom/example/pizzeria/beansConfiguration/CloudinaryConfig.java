package brunocapobiancocom.example.pizzeria.beansConfiguration;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CloudinaryConfig
{
    @Bean
    public Cloudinary cloudinaryUploader(@Value("${cloudinary.name}")String name,
                                         @Value("${cloudinary.apikey}")String apikey,
                                         @Value("${cloudinary.secret}")String secret)
    {
        Map<String, String> config=new HashMap<>();
        config.put("cloud_name",name);
        config.put("api_key",apikey);
        config.put("api_secret",secret);
        return new Cloudinary(config);
    }

}
