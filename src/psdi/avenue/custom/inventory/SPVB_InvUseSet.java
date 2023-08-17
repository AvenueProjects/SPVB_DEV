package psdi.avenue.custom.inventory;

import psdi.app.inventory.InvUseSet;
import psdi.mbo.Mbo;
import psdi.mbo.MboServerInterface;
import psdi.mbo.MboSet;
import psdi.util.MXException;

import java.rmi.RemoteException;

public class SPVB_InvUseSet extends InvUseSet {
    public SPVB_InvUseSet(MboServerInterface ms) throws MXException, RemoteException {
        super(ms);
    }

    @Override
    protected Mbo getMboInstance(MboSet ms) throws MXException, RemoteException {
        return new SPVB_InvUse(ms);
    }
}
