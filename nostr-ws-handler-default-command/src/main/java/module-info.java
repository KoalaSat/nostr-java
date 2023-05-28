/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module nostr.ws.handler.command.provider {
    requires nostr.ws.handler;
    requires nostr.util;
    requires nostr.base;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires nostr.crypto;
    requires nostr.json;
    requires static lombok;
    requires nostr.types;
    requires java.logging;
    
    exports nostr.ws.handler.command.provider;
    
    provides nostr.ws.handler.command.spi.ICommandHandler with nostr.ws.handler.command.provider.DefaultCommandHandler;

}
