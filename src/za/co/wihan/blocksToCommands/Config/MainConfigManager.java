package za.co.wihan.blocksToCommands.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * This class was created on 1/12/2017 in the project Bukkit Tutorials by DeveloperB.
 */

public class MainConfigManager {

    private MainConfigManager() {
    }

    private static MainConfigManager instance = new MainConfigManager();

    public static MainConfigManager getInstance() {
        return instance;
    }

    private File file;
    private FileConfiguration config;

    public void setup(Plugin plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        file = new File(plugin.getDataFolder(), "config.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(file);

    }

    public void reloadMainConfig(){config = YamlConfiguration.loadConfiguration(file);}

    public void set(String path, Object value) {
        config.set(path, value);
    }

    public Object get(String path) {
        return config.get(path);
    }

    public boolean contains(String path) {
        return config.contains(path);
    }

    public Set<String> getKeys() {
        return config.getKeys(false);
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}