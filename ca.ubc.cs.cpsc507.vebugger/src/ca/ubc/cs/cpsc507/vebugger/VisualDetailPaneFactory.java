package ca.ubc.cs.cpsc507.vebugger;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.debug.ui.IDetailPane;
import org.eclipse.debug.ui.IDetailPaneFactory;
import org.eclipse.jface.viewers.IStructuredSelection;

import ca.ubc.cs.cpsc507.vebugger.ui.views.variables.details.VisualDetailPane;

public class VisualDetailPaneFactory implements IDetailPaneFactory {

    @Override
    public Set<String> getDetailPaneTypes(IStructuredSelection selection) {
        Set<String> possibleIDs = new HashSet<String>(1);
        possibleIDs.add(VisualDetailPane.VISUAL_DETAIL_PANE_ID);
        return possibleIDs;
    }

    @Override
    public String getDefaultDetailPane(IStructuredSelection selection) {
        return VisualDetailPane.VISUAL_DETAIL_PANE_ID;
    }

    @Override
    public IDetailPane createDetailPane(String paneID) {
        return new VisualDetailPane();
    }

    @Override
    public String getDetailPaneName(String paneID) {
        if (paneID.equals(VisualDetailPane.VISUAL_DETAIL_PANE_ID)) {
            return VisualDetailPane.VISUAL_DETAIL_PANE_NAME;
        }
        return null;
    }

    @Override
    public String getDetailPaneDescription(String paneID) {
        if (paneID.equals(VisualDetailPane.VISUAL_DETAIL_PANE_ID)) {
            return VisualDetailPane.VISUAL_DETAIL_PANE_DESCRIPTION;
        }
        return null;
    }

}
