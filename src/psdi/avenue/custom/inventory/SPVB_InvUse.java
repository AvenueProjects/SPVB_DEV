package psdi.avenue.custom.inventory;

import psdi.app.inventory.InvUse;
import psdi.mbo.MboRemote;
import psdi.mbo.MboSet;
import psdi.mbo.MboSetRemote;
import psdi.util.MXApplicationException;
import psdi.util.MXException;

import java.rmi.RemoteException;
import java.util.Vector;

public class SPVB_InvUse extends InvUse {

    public SPVB_InvUse(MboSet ms) throws MXException, RemoteException {
        super(ms);
    }

    public void spvb_createMISC(MboSetRemote sourceMBOLineSet) throws MXException, RemoteException {
        Vector<MboRemote> selectedMBOLines = sourceMBOLineSet.getSelection();
        if (selectedMBOLines.size() == 0) {
            throw new MXApplicationException("contract", "selectAtLeastOne");
        }

        for (int i = 0; i < selectedMBOLines.size(); ++i) {
            MboRemote invuLineRemote = (MboRemote) selectedMBOLines.elementAt(i);
            this.spvb_createInvuLine(invuLineRemote);
        }
    }

    private void spvb_createInvuLine(MboRemote sourceRemote) throws MXException, RemoteException {
        MboSetRemote invuline = this.getMboSet("INVUSELINE");
        MboRemote invUseLineRemote = invuline.addAtEnd();
        //invUseLineRemote.setValue("FROMBIN", sourceRemote.getString("TOBIN"), 11L);
        //invUseLineRemote.setValue("FROMLOT", sourceRemote.getString("TOLOT"), 11L);
       // invUseLineRemote.setValue("TOLOT", sourceRemote.getString("TOLOT"), 11L);
        invUseLineRemote.setValue("linetype", "ITEM", 11L);
    //    invUseLineRemote.setValue("DESCRIPTION", sourceRemote.getString("DESCRIPTION"), 11L);
        invUseLineRemote.setValue("itemnum", sourceRemote.getString("itemnum"), 11L);
       // invUseLineRemote.setValue("POGLDEBITACCT", sourceRemote.getString("GLDEBITACCT"), 11L);
       // invUseLineRemote.setValue("INSPECTIONREQUIRED", sourceRemote.getString("INSPECTIONREQUIRED"), 11L);
       // invUseLineRemote.setValue("DISPLAYUNITCOST", sourceRemote.getString("AVGCOST"), 11L);
       // invUseLineRemote.setValue("UNITCOST", sourceRemote.getString("AVGCOST"), 11L);
       // invUseLineRemote.setValue("QUANTITY", sourceRemote, 11L);
       // invUseLineRemote.setValue("DISPLAYLINECOST", sourceRemote, 11L);
       // invUseLineRemote.setValue("ITEMSETID", sourceRemote.getString("ITEMSETID"), 11L);
       // invUseLineRemote.setValue("CONTRACTANALYSISCODE", sourceRemote.getString("CONTRACTANALYSISCODE"), 11L);
       // invUseLineRemote.setValue("VENDORCODE", sourceRemote.getString("VENDOR"), 11L);

    }

}
