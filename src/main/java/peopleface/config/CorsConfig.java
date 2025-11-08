package peopleface.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 1. Especifica el dominio de tu Frontend (Azure)
        // Sustituye '*' por la URL real de Azure Static Apps cuando vayas a producción
        registry.addMapping("/api/v1/**")
                .allowedOrigins("https://wonderful-ocean-0ef367510.3.azurestaticapps.net")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite los métodos necesarios
                .allowedHeaders("*") // Permite todos los encabezados
                .allowCredentials(true); // Opcional: si usas cookies o sesiones

        // 2. Si quieres permitir cualquier origen (NO recomendado para producción, pero útil para testing rápido):
        // registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
    }
}