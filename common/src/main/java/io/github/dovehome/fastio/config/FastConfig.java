package io.github.dovehome.fastio.config;

import com.google.gson.annotations.SerializedName;

public class FastConfig {

    public static final FastConfig DEFAULT = new FastConfig();

    static {
        DEFAULT.A = 1;
        DEFAULT.B = 3;
        DEFAULT.C = 5;
        DEFAULT.D = 30;
        DEFAULT.E = 1;
        DEFAULT.F = 30;
    }

    @SerializedName("A")
    public int A;

    @SerializedName("B")
    public int B;

    @SerializedName("C")
    public int C;

    @SerializedName("D")
    public int D;

    @SerializedName("E")
    public int E;

    @SerializedName("F")
    public int F;


}
