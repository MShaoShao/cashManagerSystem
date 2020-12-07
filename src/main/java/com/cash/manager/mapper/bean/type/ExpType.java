package com.cash.manager.mapper.bean.type;

/**
 * 花销类型
 *
 * @author MiaoShaoDong
 * @date 16:20 2020/9/18
 */
public enum ExpType {
    /**
     * 购钢板
     */
    STEEL_VENEER(0),

    /**
     * 购方管
     */
    STEEL_TUBE(1),
    /**
     * 购泡沫
     */
    FOAM(2),
    /**
     * 发工资
     */
    SALARY(3),
    /**
     * 修理费
     */
    FIX(4),
    /**
     * 加油费
     */
    ADD_OIL(5),
    /**
     * 其它
     */
    OTHER(6);


    private int typeId;

    ExpType(int typeId) {
        this.typeId = typeId;
    }

    public static ExpType getTypeName(int typeId) {
        ExpType type = null;

        switch (typeId) {
            case 0:
                type = STEEL_VENEER;
                break;
            case 1:
                type = STEEL_TUBE;
                break;
            case 2:
                type = FOAM;
                break;
            case 3:
                type = SALARY;
                break;
            case 4:
                type = FIX;
                break;
            case 5:
                type = ADD_OIL;
                break;
            default:
                type = OTHER;
                break;
        }
        return type;
    }

    /**
     * Gets typeId.
     *
     * @return the typeId
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Sets typeId.
     *
     * @param typeId the typeId
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
