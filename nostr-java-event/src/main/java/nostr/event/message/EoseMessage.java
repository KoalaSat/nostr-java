
package nostr.event.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import nostr.base.Command;
import nostr.event.impl.GenericMessage;

/**
 *
 * @author squirrel
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class EoseMessage extends GenericMessage {

    @JsonProperty
    private final String subscriptionId;

    public EoseMessage(String subId) {
        super(Command.EOSE.name());
        this.subscriptionId = subId;
    }
    
}
