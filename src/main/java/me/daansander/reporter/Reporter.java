package me.daansander.reporter;

import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by Daan on 20-4-2015.
 */
public class Reporter extends Plugin {

    

    public Configuration configuration = null;
    public Configuration settings = null;
    private static Reporter plugin = null;

    public void onEnable() {
        plugin = this;

        PluginManager pm = ProxyServer.getInstance().getPluginManager();
        pm.registerCommand(this, new ReportCommand());
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        loadConfigs();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public static Reporter getPlugin() {
        return plugin;
    }

    public void saveConfig() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadConfigs() {

        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                try (InputStream is = getResourceAsStream("config.yml");
                     OutputStream os = new FileOutputStream(configFile)) {
                    ByteStreams.copy(is, os);
                }
            } catch (IOException e) {
                throw new RuntimeException("Unable to create configuration file", e);
            }
        }
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        File settingfile = new File(getDataFolder(), "config.yml");
        if (!settingfile.exists()) {
            try {
                settingfile.createNewFile();
                try (InputStream is = getResourceAsStream("configuration.yml");
                     OutputStream os = new FileOutputStream(settingfile)) {
                    ByteStreams.copy(is, os);
                }
            } catch (IOException e) {
                throw new RuntimeException("Unable to create configuration file", e);
            }
        }
        try {
            settings = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "configuration.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
