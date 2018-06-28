package ru.airiva.service.cg;

import org.springframework.stereotype.Service;
import ru.airiva.entities.OrderedExpressionEntity;
import ru.airiva.entities.TlgChatEntity;
import ru.airiva.entities.TlgChatPairEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ivan
 */
@Service
public class KryptoParserCgService {

    public Set<OrderedExpressionEntity> obtainExpressions(final String phone, final long source) {
        Set<OrderedExpressionEntity> orderedExpressions = new HashSet<>();
        //TODO
        return orderedExpressions;
    }

    public Set<TlgChatPairEntity> obtainTlgChatPairs(final String phone) {
        Set<TlgChatPairEntity> pairs = new HashSet<>();
        //TODO
        return pairs;
    }

    public TlgChatPairEntity obtainTlgChatPair(final String phone, final long source, final long target) {
        TlgChatPairEntity pair = null;
        //TODO
        pair = new TlgChatPairEntity();
        TlgChatEntity srcChat = new TlgChatEntity();
        srcChat.setChannel(true);
        srcChat.setTlgChatId(source);
        pair.setSrcChat(srcChat);

        TlgChatEntity destChat = new TlgChatEntity();
        destChat.setChannel(true);
        destChat.setTlgChatId(target);
        pair.setDestChat(destChat);

        return pair;
    }

}
