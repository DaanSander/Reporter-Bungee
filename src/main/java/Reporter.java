import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Daan on 20-4-2015.
 */
public class Reporter extends Plugin {

    public Configuration configuration;

    public void onEnable() {
        System.out.println("Loading Configuration...");
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
            System.out.println("Loaded Configuration!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error ocurred while trying to load the configuration file");
        }
    }
}
