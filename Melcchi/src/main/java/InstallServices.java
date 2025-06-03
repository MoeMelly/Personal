public class InstallServices {
    DivinesWigs wigs;
    DivinesLashes lashes;
    DivinesExtensions extensions;


    public InstallServices(DivinesExtensions extensions, DivinesLashes lashes, DivinesWigs wigs) {
        this.extensions = extensions;
        this.lashes = lashes;
        this.wigs = wigs;
    }

    public DivinesExtensions getExtensions() {
        return extensions;
    }

    public DivinesLashes getLashes() {
        return lashes;
    }

    public DivinesWigs getWigs() {
        return wigs;
    }
    public double serviceHairInstalls(DivinesWigs wigs,DivinesExtensions extensions) {

    }
}
