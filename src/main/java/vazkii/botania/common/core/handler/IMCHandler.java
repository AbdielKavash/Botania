package vazkii.botania.common.core.handler;

import com.google.common.collect.ImmutableList;
import cpw.mods.fml.common.event.FMLInterModComms.IMCMessage;
import java.util.Iterator;
import vazkii.botania.common.item.equipment.bauble.ItemMagnetRing;
import vazkii.botania.common.lib.LibMisc;

public final class IMCHandler {

    public static void processMessages(ImmutableList<IMCMessage> messageList) {
        Iterator<IMCMessage> iterator = messageList.iterator();
        while (iterator.hasNext()) {
            IMCMessage message = iterator.next();
            if (message != null
                    && message.key != null
                    && message.key.equals(LibMisc.BLACKLIST_ITEM)
                    && message.isStringMessage()) {
                String value = message.getStringValue();
                ItemMagnetRing.addItemToBlackList(value);
            }
        }
    }
}
