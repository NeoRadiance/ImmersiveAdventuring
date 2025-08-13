package team.neoradiance.immersiveadventuring;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Lib.Modid)
public class ModDataGeneratorHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
         // Data generators may require some of these as constructor parameters.
    // See below for more details on each of these.
    DataGenerator generator = event.getGenerator();
    PackOutput output = generator.getPackOutput();
    ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    // Register the provider.
    generator.addProvider(
            // A boolean that determines whether the data should actually be generated.
            // The event provides methods that determine this:
            // event.includeClient(), event.includeServer(),
            // event.includeDev() and event.includeReports().
            // Since recipes are server data, we only run them in a server datagen.
            event.includeServer(),
            // Our provider.
            new ModRecipeProvider(output, lookupProvider)
    );
    // Other data providers here.
    }
}