package io.github.dovehome.fastio.db;

import net.minecraft.nbt.CompoundTag;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

public class FastEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -909993760655853799L;

    public UUID uuid;
    public final File file;

    public FastEntity(File file) throws IOException {
        this.file = file;
    }


    public void write(ObjectOutputStream oos) throws IOException {
        oos.writeUTF(Objects.requireNonNullElse(uuid, UUID.randomUUID()).toString());

    }

    public void read(ObjectInputStream ois) throws IOException {
        uuid = UUID.fromString(ois.readUTF());

    }
}
