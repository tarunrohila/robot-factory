package de.tech26.robotfactory.dto;

/**
 * Class which is used to create object from {@link Robot}
 *
 * @author Tarun Rohila
 */
public class Robot {

    /**
     * Variable declaration for face
     */
    private RobotPart face;

    /**
     * Variable declaration for material
     */
    private RobotPart material;

    /**
     * Variable declaration for arms
     */
    private RobotPart arms;

    /**
     * Variable declaration for mobility
     */
    private RobotPart mobility;

    public Robot(Builder builder) {
        this.face = builder.face;
        this.material = builder.material;
        this.arms = builder.arms;
        this.mobility = builder.mobility;
    }

    // Builder inner static class
    public static class Builder {
        /**
         * Variable declaration for face
         */
        private RobotPart face;

        /**
         * Variable declaration for material
         */
        private RobotPart material;

        /**
         * Variable declaration for arms
         */
        private RobotPart arms;

        /**
         * Variable declaration for mobility
         */
        private RobotPart mobility;

        // No-arg constructor
        public Builder() {
        }

        public Robot build() {
            return new Robot(this);
        }

        public Builder face(RobotPart face) {
            this.face = face;
            return this;
        }

        public Builder material(RobotPart material) {
            this.material = material;
            return this;
        }

        public Builder arms(RobotPart arms) {
            this.arms = arms;
            return this;
        }

        public Builder mobility(RobotPart mobility) {
            this.mobility = mobility;
            return this;
        }
    }

    /**
     * Method to get the value of face
     *
     * @return face - face
     */
    public RobotPart getFace() {
        return face;
    }

    /**
     * Method to set the value of face
     *
     * @param face - face
     */
    public void setFace(RobotPart face) {
        this.face = face;
    }

    /**
     * Method to get the value of material
     *
     * @return material - material
     */
    public RobotPart getMaterial() {
        return material;
    }

    /**
     * Method to set the value of material
     *
     * @param material - material
     */
    public void setMaterial(RobotPart material) {
        this.material = material;
    }

    /**
     * Method to get the value of arms
     *
     * @return arms - arms
     */
    public RobotPart getArms() {
        return arms;
    }

    /**
     * Method to set the value of arms
     *
     * @param arms - arms
     */
    public void setArms(RobotPart arms) {
        this.arms = arms;
    }

    /**
     * Method to get the value of mobility
     *
     * @return mobility - mobility
     */
    public RobotPart getMobility() {
        return mobility;
    }

    /**
     * Method to set the value of mobility
     *
     * @param mobility - mobility
     */
    public void setMobility(RobotPart mobility) {
        this.mobility = mobility;
    }
}
