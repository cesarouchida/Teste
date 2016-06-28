package br.com.casadocodigo.loja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;

public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistable<ID>{

    private static final long serialVersionUID = -8136641069376872170L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public void setId(ID id) {
        super.setId(id);
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return super.isNew();
    }
}
