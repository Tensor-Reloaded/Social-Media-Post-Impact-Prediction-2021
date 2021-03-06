package uaic.info.account_management_service.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterConfig {
    @Value("${consumerKey}")
    private String consumerKey;

    @Value("${consumerSecret}")
    private String consumerSecret;

    @Bean
    @RequestScope
    public Twitter init(){
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(consumerKey);
        builder.setOAuthConsumerSecret(consumerSecret);
        twitter4j.conf.Configuration configuration = builder.build();
        TwitterFactory factory = new TwitterFactory(configuration);
        return factory.getInstance();
    }
}
