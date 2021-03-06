package ru.airiva.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

import static ru.airiva.entities.EntityConstants.CHAT_PAIRS;
import static ru.airiva.entities.EntityConstants.CHAT_PAIRS_GEN;
import static ru.airiva.entities.EntityConstants.CHAT_PAIRS_SEQ;

/**
 * @author Ivan
 */
@Entity
@Table(name = CHAT_PAIRS)
@SequenceGenerator(name = CHAT_PAIRS_GEN, sequenceName = CHAT_PAIRS_SEQ, allocationSize = 1)
public class TlgChatPairEntity {

    @Id
    @GeneratedValue(generator = CHAT_PAIRS_GEN, strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "src_chat_id")
    private TlgChatEntity srcChat;

    @OneToOne
    @JoinColumn(name = "dest_chat_id")
    private TlgChatEntity destChat;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_pair_id")
    private Set<OrderedExpressionEntity> orderedExpressionEntities;

    @Column(name = "delay")
    private long delay = 0;

    @ManyToOne
    @JoinColumn(name = "tr_package_id")
    private TlgTrPackageEntity tlgTrPackageEntity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private TlgClientEntity tlgClientEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TlgChatEntity getSrcChat() {
        return srcChat;
    }

    public void setSrcChat(TlgChatEntity srcChat) {
        this.srcChat = srcChat;
    }

    public TlgChatEntity getDestChat() {
        return destChat;
    }

    public void setDestChat(TlgChatEntity destChat) {
        this.destChat = destChat;
    }

    public Set<OrderedExpressionEntity> getOrderedExpressionEntities() {
        return orderedExpressionEntities;
    }

    public void setOrderedExpressionEntities(Set<OrderedExpressionEntity> orderedExpressionEntities) {
        this.orderedExpressionEntities = orderedExpressionEntities;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public TlgTrPackageEntity getTlgTrPackageEntity() {
        return tlgTrPackageEntity;
    }

    public void setTlgTrPackageEntity(TlgTrPackageEntity tlgTrPackageEntity) {
        this.tlgTrPackageEntity = tlgTrPackageEntity;
    }

    public TlgClientEntity getTlgClientEntity() {
        return tlgClientEntity;
    }

    public void setTlgClientEntity(TlgClientEntity tlgClientEntity) {
        this.tlgClientEntity = tlgClientEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TlgChatPairEntity that = (TlgChatPairEntity) o;
        return Objects.equals(srcChat, that.srcChat) &&
                Objects.equals(destChat, that.destChat) &&
                Objects.equals(tlgTrPackageEntity, that.tlgTrPackageEntity) &&
                Objects.equals(tlgClientEntity, that.tlgClientEntity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(srcChat, destChat, tlgTrPackageEntity, tlgClientEntity);
    }
}
