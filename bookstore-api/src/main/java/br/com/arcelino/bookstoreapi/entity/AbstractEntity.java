package br.com.arcelino.bookstoreapi.entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractEntity<T extends Serializable> implements Serializable {

    public abstract T getId();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AbstractEntity))
            return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return getId() != null ? getId().toString() : super.toString();
    }
}