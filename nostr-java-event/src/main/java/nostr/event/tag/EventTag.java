/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nostr.event.tag;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import nostr.base.annotation.Key;
import nostr.base.annotation.Tag;
import nostr.event.BaseTag;
import nostr.event.Marker;

/**
 *
 * @author squirrel
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Tag(code = "e", name = "event")
@JsonPropertyOrder({"idEvent", "recommendedRelayUrl", "marker"})
@NoArgsConstructor
public class EventTag extends BaseTag {

    @Key
    @JsonProperty("idEvent")
    private String idEvent;

    @Key
    @JsonProperty("recommendedRelayUrl")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String recommendedRelayUrl;

    @Key(nip = 10)
    @JsonProperty("marker")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Marker marker;

    public EventTag(String idEvent) {
        this.recommendedRelayUrl = null;
        this.idEvent = idEvent;
        this.marker = this.idEvent == null ? Marker.ROOT : Marker.REPLY;
    }
}
