public class InstallServices {
    DivinesWigs wigs;
    DivinesLashes lashes;
    DivinesExtensions extensions;
    boolean customize;
    boolean wigRevamp;
    boolean extraHair;
    boolean bringOwnPrep;
    boolean installationFee = false;


    public InstallServices(DivinesExtensions extensions, boolean customize, boolean wigRevamp, boolean extraHair, boolean bringOwnPrep, boolean installationFee, DivinesLashes lashes, DivinesWigs wigs) {
        this.extensions = extensions;
        this.customize = customize;
        this.wigRevamp = wigRevamp;
        this.extraHair = extraHair;
        this.bringOwnPrep = bringOwnPrep;
        this.lashes = lashes;
        this.wigs = wigs;
        this.installationFee = installationFee;

    }

    public boolean isInstallationFee() {
        return installationFee;
    }

    public boolean isWigRevamp() {
        return wigRevamp;
    }

    public DivinesExtensions getExtensions() {
        return extensions;
    }

    public InstallServices(boolean customize) {
        this.customize = customize;
    }

    public DivinesLashes getLashes() {
        return lashes;
    }

    public DivinesWigs getWigs() {
        return wigs;
    }

    public double wigInstalls(DivinesWigs wigs) {
        int deposit = 150;
        double basicWigInstall = 50.00;
        double WigRevamp = 80.00;
        double customization = 50.00;
        double totalCost = 0.0;

        switch (wigs) {
            case FRONT_LACE_WIG:
            case FULL_LACE_WIG:
            case LACE_FRONT_WIG:
            case V_PART_WIG:
            case GLUELESS_WIG:
                totalCost += basicWigInstall + getWigs().getPrice() + deposit;
                break;
            default:
                throw new RuntimeException();
        }

        if (customize) {
            totalCost += customization;
        } else if (wigRevamp) {
            totalCost += WigRevamp;

        } else {
            throw new RuntimeException();
        }


        return totalCost;
    }

    public double extenionInstalls(DivinesExtensions extensions, double price) {
        int deposit = 80;
        double basePrice = 100;
        double hasOwnPrep = 45.00;
        double moreExtraHair = 130.00;
        double totalCost = 0.0;

        switch (extensions) {
            case SEW_IN:
            case HALO_EXTENSIONS:
            case CLIP_IN_EXTENSIONS:
            case TAPE_IN_EXTENSIONS:
                totalCost += getExtensions().getPrice() + deposit;


                if (bringOwnPrep) {
                    totalCost += hasOwnPrep;
                } else if (extraHair) {
                    totalCost += moreExtraHair;
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid wig type: " + wigs);
        }
        return totalCost;
    }

    public double lashInstalls(DivinesLashes lashes) {
        int deposit = 120;
        double basePrice = 90;
        double totalPrice = 0.0;
        double installFee = 110.00;

        switch (lashes) {
            case LASH_BUNDLES:
            case MINK_LASHES:
            case FAUX_MINK_LASHES:
            case NATURAL_DAILY_LASHES:
                totalPrice += getLashes().getPrice() + deposit;
                break;
            default:
                throw new IllegalArgumentException("Invalid lash type: ");
        }

                if (installationFee) {}totalPrice += installFee;


        return totalPrice;
    }


    }











