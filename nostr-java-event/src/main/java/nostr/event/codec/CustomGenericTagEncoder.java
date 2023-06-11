package nostr.event.codec;

import java.io.IOException;
import java.util.logging.Level;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import lombok.extern.java.Log;
import nostr.base.GenericTagQuery;
import nostr.base.IMarshaller;

/**
 * @author guilhermegps
 *
 */
@Log
public class CustomGenericTagEncoder extends StdSerializer<GenericTagQuery> {

    private static final long serialVersionUID = 6803478463890319884L;

    public CustomGenericTagEncoder() {
        super(GenericTagQuery.class);
    }

    @Override
    public void serialize(GenericTagQuery value, JsonGenerator gen, SerializerProvider serializers) {
        try {
            gen.writePOJO(toJson(value));
        } catch (IOException e) {
            log.log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    public static JsonNode toJson(GenericTagQuery gtq) {
        var mapper = IMarshaller.MAPPER;
        try {
            JsonNode node = mapper.valueToTree(gtq);
            ObjectNode objNode = (ObjectNode) node;
            objNode.set("#" + node.get("tagName").textValue(), node.get("value"));
            objNode.remove("tagName");
            objNode.remove("value");

            return node;
        } catch (IllegalArgumentException e) {
            log.log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

}
