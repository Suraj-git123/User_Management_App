@SpringBootApplication
public class MiniProjectUserMgmtApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MiniProjectUserMgmtApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MiniProjectUserMgmtApp.class, args);
    }
}

