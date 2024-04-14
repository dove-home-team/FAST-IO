package io.github.dovehome.fastio.db;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class FastEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -909993760655853799L;

    public String initializeName;
    public UUID uuid;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FastEntity that = (FastEntity) o;
        return Objects.equals(initializeName, that.initializeName) && Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initializeName, uuid);
    }
}
