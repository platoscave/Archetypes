package gov.wa.wsdot.apps.mgwtbasic.client.activities.home;

import java.util.ArrayList;
import java.util.List;

import gov.wa.wsdot.apps.mgwtbasic.client.ClientFactory;
import gov.wa.wsdot.apps.mgwtbasic.client.activities.about.AboutPlace;
import gov.wa.wsdot.apps.mgwtbasic.client.activities.sample.SamplePlace;
import gov.wa.wsdot.apps.mgwtbasic.shared.Topic;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class HomeActivity extends MGWTAbstractActivity implements
		HomeView.Presenter {

	private final ClientFactory clientFactory;
	private HomeView view;
		
	public HomeActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getHomeView();
		view.setPresenter(this);
		view.render(createTopicsList());
		view.refresh();
		
		panel.setWidget(view);
	}

    private List<Topic> createTopicsList() {
        ArrayList<Topic> list = new ArrayList<Topic>();
        
        list.add(new Topic("Sample Activity"));
        
        return list;
    }

    @Override
	public void onAboutButtonPressed() {
		clientFactory.getPlaceController().goTo(new AboutPlace());
	}

    @Override
    public void onItemSelected(int index) {
        if (index == 0) {
            clientFactory.getPlaceController().goTo(new SamplePlace());
            
            return;
        }        
    }

}