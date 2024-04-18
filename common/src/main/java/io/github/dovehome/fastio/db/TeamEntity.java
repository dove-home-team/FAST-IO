package io.github.dovehome.fastio.db;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TeamEntity extends FastEntity {
    int A = 1, B = 3, C = 5, D = 30, E = 1, F = 30;
    public static final Map<Long, Double> levelExperience = new ConcurrentHashMap<>();//升级所需要的经验划分
    public static final ConcurrentHashMap<Long, Integer> levelSize = new ConcurrentHashMap<>();//指定等级所需要的玩家数量统计
    private String teamName;//队伍名
    private int playerSize;//玩家上限数量(队伍等级改动)
    private long teamLevel;//队伍等级
    private double teamExperience;//队伍经验

    public TeamEntity(File file) throws IOException {
        super(file);
        if (levelExperience.isEmpty()) {

            for (int i = 0; i < 101; i++) {
                levelExperience.put((long)i, (double) i*i*i*A+i*i*B+i*C+D);
            }
        }
    }

    @Override
    public void write(ObjectOutputStream oos) throws IOException {
        super.write(oos);
        oos.writeUTF(Objects.requireNonNullElse(teamName, uuid.toString()));
        oos.writeLong(teamLevel);
        oos.writeDouble(teamExperience);
    }

    @Override
    public void read(ObjectInputStream ois) throws IOException {
        super.read(ois);
        teamName = ois.readUTF();
        teamLevel = ois.readLong();
        playerSize = levelSize.getOrDefault(teamLevel, 5);
        teamExperience = ois.readDouble();
    }

    public int playerSize() {
        return playerSize;
    }

    public void playerSize(int playerSize) {
        this.playerSize = playerSize;
    }
}
