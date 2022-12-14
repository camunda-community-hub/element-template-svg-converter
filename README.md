[![Community Extension](https://img.shields.io/badge/Community%20Extension-An%20open%20source%20community%20maintained%20project-FF4700)](https://github.com/camunda-community-hub/community)
[![](https://img.shields.io/badge/Lifecycle-Incubating-blue)](https://github.com/Camunda-Community-Hub/community/blob/main/extension-lifecycle.md#incubating-)
![Compatible with: Camunda Platform 8](https://img.shields.io/badge/Compatible%20with-Camunda%20Platform%208-0072Ce)

# Element Template SVG converter

With Camunda 8 you are now able to attach custom icons to items in Element Templates. SVGs (Scalable Vector Graphics) are ideal since they are vector, rather than raster, diagrams meaning they can scale infinitely in size while retaining their original fidelity. This utility will convert SVG diagrams for use as 18px by 18px task icons. A growing library of converted icons is available (see below) for you to copy and paste into an Element Template file. Or you can use this sample [Element Template file](./element-template-sample/elementTemplates.json) to access all of the icons at once. Note, the elements have been associated with User Tasks and can be changed as needed.

# Table of Contents
1. [Converted SVGs](#convertedSVGs)
2. [Fun with flags](#funWithFlags)
3. [The SVG converter utilities](#svgConverter)
4. [Using Inkscape](#usingInkscape)

## Converted SVGs <a name="convertedSVGs"></a>
You can simply copy and paste these ready made snippets into the ```"icon": { "contents":``` portion of your Element Template entry. They have been created at a width of 18px. Click on image to be brought to the Element Template SVG snippet. Note, with the introduction of Modeler 5.2 the 18px by 18px icon dimensions are strictly enforced which will result in shrunken icons in some cases.


<h2> Camunda Logos </h2>

<table>
<tr><td width="150px" align=center><b>Black</b></td><td width="150px" align=center><b>Orange</b></td><td width="150px" align=center><b>28px wide</b></td><td width="150px" align=center><b>Animated Classic</b></td><td width="150px" align=center><b>Classic</b></td></tr>
<tr><td><a href="./converted-svg-snippets/CamundaLogo.txt"><img src="./svgs/new-camunda-logo.svg"></a></td><td><a href="./converted-svg-snippets/orangeCamundaLogo.txt"><img src="./svgs/new-camunda-logo-orange.svg"></a></td><td><a href="./converted-svg-snippets/camunda.txt"><img src="./svgs/Logo_Black.svg"></a></td><td><a href="./converted-svg-snippets/CamundaClassicLogoAnimated.txt"><img src="./svgs/old-logo-animated_CSS.svg"></a></td><td><a href="./converted-svg-snippets/CamundaClassicLogo.txt"><img src="./svgs/old-camunda-logo.svg"></a></td></tr>
<table>

<h2> Camundamojis </h2>

<table>
<tr><td width="150px" align=center><b>Happy</b></td><td width="150px" align=center><b>Neutral</b></td><td width="150px" align=center><b>Concerned</b></td><td width="150px" align=center><b>Mad</b></td></tr>
<tr><td><a href="./converted-svg-snippets/happy.txt"><img src="./svgs/Emoji-Happy-Yes.svg"></a></td><td><a href="./converted-svg-snippets/meh.txt"><img src="./svgs/Emoji-Neutral.svg"></a></td><td><a href="./converted-svg-snippets/emojiConcerned.txt"><img src="./svgs/Emoji-Concerned.svg"></a></td><td><a href="./converted-svg-snippets/mad.txt"><img src="./svgs/Emoji-Mad-No.svg"></a></td></tr>
<table>

<h2> Friends </h2>

<table>
<tr><td width="150px" align=center><b>Extraterrestrial</b></td><td width="150px" align=center><b>Blue Robot</b></td><td width="150px" align=center><b>Yellow Robot</b></td><td width="150px" align=center><b>Green Monster</b></td><td width="150px" align=center><b>Orange Monster</b></td><td width="150px" align=center><b>Dude</b></td><td width="150px" align=center><b>Pirate</b></td><td width="150px" align=center><b>Pigeon Hawk</b></td></tr>
<tr><td><a href="./converted-svg-snippets/alien.txt"><img src="./svgs/Friendly-Alien.svg"></a></td><td><a href="./converted-svg-snippets/blueRobot.txt"><img src="./svgs/Robot-Blue.svg"></a></td><td><a href="./converted-svg-snippets/yellowRobot.txt"><img src="./svgs/Robot-Yellow.svg"></a></td><td><a href="./converted-svg-snippets/greenMonster.txt"><img src="./svgs/Monster-Green.svg"></a></td><td><a href="./converted-svg-snippets/orangeMonster.txt"><img src="./svgs/Monster-Orange.svg"></a></td><td><a href="./converted-svg-snippets/dude.txt"><img src="./svgs/Dude.svg"></a></td><td><a href="./converted-svg-snippets/pirate.txt"><img src="./svgs/Pirate.svg"></a></td><td><a href="./converted-svg-snippets/pigeonHawk.txt"><img src="./svgs/Pigeon-Hawk.svg"></a></td></tr>
<table>

<h2> Coffee </h2>

<table>
<tr><td width="150px" align=center><b>Coffee cup</b></td><td width="150px" align=center><b>Grey coffee cup</b></td><td width="150px" align=center><b>Coffee circle</b></td><td width="150px" align=center><b>Yellow coffee circle</b></td></tr>
<tr><td><a href="./converted-svg-snippets/coffeeCup.txt"><img src="./svgs/coffee-cup.svg"></a></td><td><a href="./converted-svg-snippets/greyCoffeeCup.txt"><img src="./svgs/coffee-cup-grey.svg"></a></td><td><a href="./converted-svg-snippets/coffeeCircle.txt"><img src="./svgs/coffee-circle.svg"></a></td><td><a href="./converted-svg-snippets/yellowCoffeeCircle.txt"><img src="./svgs/coffee-circle-yellow.svg"></a></td></tr>
<table>

<h2> Other logos </h2>

<table>
<tr><td width="150px" align=center><b>Github</b></td><td width="150px" align=center><b>Slack</b></td><td width="150px" align=center><b>Stack Overflow</b></td><td width="150px" align=center><b>Twitter</b></td><td width="150px" align=center><b>YouTube</b></td><td width="150px" align=center><b>LinkedIn</b></td><td width="150px" align=center><b>Facebook</b></td></tr>
<tr><td><a href="./converted-svg-snippets/github_black.txt"><img src="./svgs/github_black.svg"></a></td><td><a href="./converted-svg-snippets/slack_black.txt"><img src="./svgs/slack_black.svg"></a></td><td><a href="./converted-svg-snippets/stack-overflow_black.txt"><img src="./svgs/stack-overflow_black.svg"></a></td><td><a href="./converted-svg-snippets/twitter_black.txt"><img src="./svgs/twitter_black.svg"></a></td><td><a href="./converted-svg-snippets/youtube_black.txt"><img src="./svgs/youtube_black.svg"></a></td><td><a href="./converted-svg-snippets/linkedin_black.txt"><img src="./svgs/linkedin_black.svg"></a></td><td><a href="./converted-svg-snippets/facebook_black.txt"><img src="./svgs/facebook_black.svg"></a></td></tr>
<table>

<h2> For the dogs </h2>

<table>
<tr><td width="150px" align=center><b>Dog food bowl</b></td><td width="150px" align=center><b>Teal dog food bowl</b></td><td width="150px" align=center><b>Dog bone</b></td><td width="150px" align=center><b>Teal dog bone</b></td></tr>
<tr><td><a href="./converted-svg-snippets/dogFoodBowl.txt"><img src="./svgs/dog-food-bowl.svg"></a></td><td><a href="./converted-svg-snippets/tealDogFoodBowl.txt"><img src="./svgs/dog-food-bowl-teal.svg"></a></td><td><a href="./converted-svg-snippets/dogBone.txt"><img src="./svgs/dog-food-bone.svg"></a></td><td><a href="./converted-svg-snippets/tealDogBone.txt"><img src="./svgs/dog-food-bone-teal.svg"></a></td></tr>
<table>

<h2> For the cats </h2>

<table>
<tr><td width="150px" align=center><b>Cat food bowl</b></td><td width="150px" align=center><b>Orange dog food bowl</b></td><td width="150px" align=center><b>Cat treat</b></td><td width="150px" align=center><b>Orange cat treat</b></td></tr>
<tr><td><a href="./converted-svg-snippets/catFoodBowl.txt"><img src="./svgs/cat-food-bowl.svg"></a></td><td><a href="./converted-svg-snippets/orangeCatFoodBowl.txt"><img src="./svgs/cat-food-bowl-orange.svg"></a></td><td><a href="./converted-svg-snippets/fishTreat.txt"><img src="./svgs/cat-food-fish-bone.svg"></a></td><td><a href="./converted-svg-snippets/orangeFishTreat.txt"><img src="./svgs/cat-food-fish-bone-orange.svg"></a></td></tr>
<table>

<h2> Huh? </h2>

<table>
<tr><td width="150px" align=center><b>Question mark</b></td><td width="150px" align=center><b>Blue question mark</b></td></tr>
<tr><td><a href="./converted-svg-snippets/questionMark.txt"><img src="./svgs/question-mark.svg"></a></td><td><a href="./converted-svg-snippets/blueQuestionMark.txt"><img src="./svgs/question-mark-blue.svg"></a></td></tr>
</table>

<h2> The rest </h2>

<table>
<tr><td width="100px"><a href="./converted-svg-snippets/add-user-team-member_black.txt"><img src="./svgs/add-user-team-member_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/add-workflow_black_black.txt"><img src="./svgs/add-workflow_black_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/AI_black.txt"><img src="./svgs/AI_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/alignment_black.txt"><img src="./svgs/alignment_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/ambition_black.txt"><img src="./svgs/ambition_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/analyze-processes_black.txt"><img src="./svgs/analyze-processes_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/announcement_black.txt"><img src="./svgs/announcement_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/API_black.txt"><img src="./svgs/API_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/balance_black.txt"><img src="./svgs/balance_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/batch-process-migration_black.txt"><img src="./svgs/batch-process-migration_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/blog_black.txt"><img src="./svgs/blog_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/BPM-gear_black.txt"><img src="./svgs/BPM-gear_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/BPMN-2.0_black.txt"><img src="./svgs/BPMN-2.0_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/bpmn-resources_black.txt"><img src="./svgs/bpmn-resources_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/build-process-workflow_black.txt"><img src="./svgs/build-process-workflow_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/business-suitcase_black.txt"><img src="./svgs/business-suitcase_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/calendar-events_black.txt"><img src="./svgs/calendar-events_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/calendar-signup_black.txt"><img src="./svgs/calendar-signup_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/Camunda-8-c8_black.txt"><img src="./svgs/Camunda-8-c8_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/case-study_black.txt"><img src="./svgs/case-study_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/checklist-audit-logging_black.txt"><img src="./svgs/checklist-audit-logging_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/checklist-rules_black.txt"><img src="./svgs/checklist-rules_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/cloud-console_black.txt"><img src="./svgs/cloud-console_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/cloud-window_black.txt"><img src="./svgs/cloud-window_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/cloud_black.txt"><img src="./svgs/cloud_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/code-architecture-review_black.txt"><img src="./svgs/code-architecture-review_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/confused-person_black.txt"><img src="./svgs/confused-person_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/connectors_black.txt"><img src="./svgs/connectors_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/consulting_black.txt"><img src="./svgs/consulting_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/conversation_black.txt"><img src="./svgs/conversation_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/cycle_black.txt"><img src="./svgs/cycle_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/database_black.txt"><img src="./svgs/database_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/decision-engine_black.txt"><img src="./svgs/decision-engine_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/digital-transformation_black.txt"><img src="./svgs/digital-transformation_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/DMN_black.txt"><img src="./svgs/DMN_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/documentation_black.txt"><img src="./svgs/documentation_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/email_black.txt"><img src="./svgs/email_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/EUR-USD_black.txt"><img src="./svgs/EUR-USD_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/excellence_black.txt"><img src="./svgs/excellence_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/FE_black.txt"><img src="./svgs/FE_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/forms_black.txt"><img src="./svgs/forms_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/forum-chat_black.txt"><img src="./svgs/forum-chat_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/FO_black.txt"><img src="./svgs/FO_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/global-cloud_black.txt"><img src="./svgs/global-cloud_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/global_black.txt"><img src="./svgs/global_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/growth-bar-graph_black.txt"><img src="./svgs/growth-bar-graph_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/handshake-onboarding_black.txt"><img src="./svgs/handshake-onboarding_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/heart_black.txt"><img src="./svgs/heart_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/homegrown-workflow_black.txt"><img src="./svgs/homegrown-workflow_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/horizontal-scalability_black.txt"><img src="./svgs/horizontal-scalability_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/humor_black.txt"><img src="./svgs/humor_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/IAM-identity_black.txt"><img src="./svgs/IAM-identity_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/idea_black.txt"><img src="./svgs/idea_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/innovation-growth_black.txt"><img src="./svgs/innovation-growth_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/inspect-review-data_black.txt"><img src="./svgs/inspect-review-data_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/integration-framework_black.txt"><img src="./svgs/integration-framework_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/integration_black.txt"><img src="./svgs/integration_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/integrity_black.txt"><img src="./svgs/integrity_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/international-team_black.txt"><img src="./svgs/international-team_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/IoT_black.txt"><img src="./svgs/IoT_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/legacy-BPMS_black.txt"><img src="./svgs/legacy-BPMS_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/lightning_black.txt"><img src="./svgs/lightning_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/link-pop-out_black.txt"><img src="./svgs/link-pop-out_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/live-video_black.txt"><img src="./svgs/live-video_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/local-communities_black.txt"><img src="./svgs/local-communities_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/microservices-orchestration_black.txt"><img src="./svgs/microservices-orchestration_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/modeler-desktop_black.txt"><img src="./svgs/modeler-desktop_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/modeler-web_black.txt"><img src="./svgs/modeler-web_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/modeler_black.txt"><img src="./svgs/modeler_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/modeling-workshop_black.txt"><img src="./svgs/modeling-workshop_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/mountain-flag_black.txt"><img src="./svgs/mountain-flag_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/network_black.txt"><img src="./svgs/network_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/newbie_black.txt"><img src="./svgs/newbie_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/newsletter_black.txt"><img src="./svgs/newsletter_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/news_black.txt"><img src="./svgs/news_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/onboarding-hand-gear_black.txt"><img src="./svgs/onboarding-hand-gear_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/open-source-initiative_black.txt"><img src="./svgs/open-source-initiative_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/open-space-meeting_black.txt"><img src="./svgs/open-space-meeting_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/operate-cockpit_black.txt"><img src="./svgs/operate-cockpit_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/optimize-workshop_black.txt"><img src="./svgs/optimize-workshop_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/people-team_black.txt"><img src="./svgs/people-team_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/people_black.txt"><img src="./svgs/people_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/person-user_black.txt"><img src="./svgs/person-user_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/play-button_black.txt"><img src="./svgs/play-button_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/podcast-microphone_black.txt"><img src="./svgs/podcast-microphone_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/power_black.txt"><img src="./svgs/power_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/priority-patches_black.txt"><img src="./svgs/priority-patches_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/public-sector_black.txt"><img src="./svgs/public-sector_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/rapid-growth_black.txt"><img src="./svgs/rapid-growth_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/redesign_black.txt"><img src="./svgs/redesign_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/resources_black.txt"><img src="./svgs/resources_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/review-optimization_black.txt"><img src="./svgs/review-optimization_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/rocket_black.txt"><img src="./svgs/rocket_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/rpa-confused_black.txt"><img src="./svgs/rpa-confused_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/rpa_black.txt"><img src="./svgs/rpa_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/search-online-software_black.txt"><img src="./svgs/search-online-software_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/search-visibility_black.txt"><img src="./svgs/search-visibility_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/security-lock_black.txt"><img src="./svgs/security-lock_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/sign-up_black.txt"><img src="./svgs/sign-up_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/software-product-workflow_black.txt"><img src="./svgs/software-product-workflow_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/speed-scalability_black.txt"><img src="./svgs/speed-scalability_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/stability_black.txt"><img src="./svgs/stability_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/stagnation_black.txt"><img src="./svgs/stagnation_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/startup-rocket_black.txt"><img src="./svgs/startup-rocket_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/support-heart-in-hand_black.txt"><img src="./svgs/support-heart-in-hand_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/support-smiley_black.txt"><img src="./svgs/support-smiley_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/systems_black.txt"><img src="./svgs/systems_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/talent_black.txt"><img src="./svgs/talent_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/task-level-orchestration_black.txt"><img src="./svgs/task-level-orchestration_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/tasklist_black.txt"><img src="./svgs/tasklist_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/technical-support_black.txt"><img src="./svgs/technical-support_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/telco-wifi_black.txt"><img src="./svgs/telco-wifi_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/thought-leadership_black.txt"><img src="./svgs/thought-leadership_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/time-speed_black.txt"><img src="./svgs/time-speed_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/training-onboarding_black.txt"><img src="./svgs/training-onboarding_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/training-presentation_black.txt"><img src="./svgs/training-presentation_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/training_black.txt"><img src="./svgs/training_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/transparency-reporting_black.txt"><img src="./svgs/transparency-reporting_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/transparency_black.txt"><img src="./svgs/transparency_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/tutorial-video_black.txt"><img src="./svgs/tutorial-video_black.svg"></a></td></tr><tr><td width="100px"><a href="./converted-svg-snippets/USD_black.txt"><img src="./svgs/USD_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/video-camera_black.txt"><img src="./svgs/video-camera_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/video-film_black.txt"><img src="./svgs/video-film_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/video-laptop_black.txt"><img src="./svgs/video-laptop_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/waterfall_black.txt"><img src="./svgs/waterfall_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/whitepaper_black.txt"><img src="./svgs/whitepaper_black.svg"></a></td><td width="100px"><a href="./converted-svg-snippets/workflow-engine-zeebe_black.txt"><img src="./svgs/workflow-engine-zeebe_black.svg"></a></td></tr><tr></table>

An example of its use in an Element Template entry (see contents):

```
{
	"$schema": "https://unpkg.com/@camunda/zeebe-element-templates-json-schema/resources/schema.json",
	"name": "Feed the cat",
	"icon": { "contents": "data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='18' height='9.565979' viewBox='0 0 18 9.565979' %3E%3Ccircle r='0.29226804' cx='6.7592783' cy='5.7293816'/%3E%3Cpath d='M 17.902576 6.643299 h 0.0046391753 L 15.810308 1.980928 h -0.0046391753 c 0.0 -0.0046391753,-0.0046391753 -0.013917526,-0.0046391753 -0.018556701 C 15.406701 0.6170103,12.094331 0.0,9.0 0.0 S 2.5932992 0.6170103,2.1989691 1.9623711 c -0.0046391753 0.0046391753,-0.0046391753 0.013917526,-0.0046391753 0.018556701 h -0.0046391753 L 0.0927835 6.643299 h 0.0046391753 c -0.064948454 0.12525773,-0.097422674 0.25979382,-0.097422674 0.39896908 c 0.0 0.75618553,0.9881443 1.3824742,2.931959 1.8695877 c 1.7025774 0.42216498,3.8551545 0.6541237,6.0680413 0.6541237 s 4.3654637 -0.23195876,6.0680413 -0.6541237 c 1.9484537 -0.4824742,2.931959 -1.1134021,2.931959 -1.8695877 C 18.0 6.903093,17.967525 6.7685566,17.902576 6.643299 L 17.902576 6.643299 M 12.32165 6.634021 l 0.42216498 1.3685567 c 0.013917526 0.041752577,-0.027835052 0.07886598,-0.06958763 0.064948454 c -0.93247426 -0.35721648,-1.401031 -1.1690723,-1.563402 -1.5262887 h -0.3618557 l -0.06958763 0.61237115 c -0.0046391753 0.05103093,-0.08350515 0.05103093,-0.08814433 0.0 l -0.06958763 -0.61237115 h -0.61237115 l -0.12525773 1.1551546 c -0.0046391753 0.05103093,-0.08350515 0.05103093,-0.08814433 0.0 l -0.12525773 -1.1551546 h -0.64484537 l -0.185567 1.6979381 c -0.0046391753 0.05103093,-0.08350515 0.05103093,-0.08814433 0.0 l -0.185567 -1.6979381 h -0.5798969 v 1.6283505 c 0.0 0.10206186,-0.08814433 0.18092784,-0.19020618 0.17164949 c -1.164433 -0.11597938,-2.4355671 -1.2386599,-2.4355671 -1.9762886 s 1.271134 -1.8649485,2.4355671 -1.9762886 c 0.10206186 -0.0092783505,0.19020618 0.06958763,0.19020618 0.17164949 v 1.6283505 h 0.5798969 l 0.185567 -1.6979381 c 0.0046391753 -0.05103093,0.08350515 -0.05103093,0.08814433 0.0 l 0.185567 1.6979381 h 0.64484537 l 0.12525773 -1.1551546 c 0.0046391753 -0.05103093,0.08350515 -0.05103093,0.08814433 0.0 l 0.12525773 1.1551546 h 0.61237115 l 0.06958763 -0.61237115 c 0.0046391753 -0.05103093,0.08350515 -0.05103093,0.08814433 0.0 l 0.06958763 0.61237115 h 0.3618557 c 0.1670103 -0.35721648,0.63092786 -1.1690723,1.563402 -1.5262887 c 0.041752577 -0.013917526,0.08350515 0.023195876,0.06958763 0.064948454 l -0.42216498 1.3685567 C 12.265979 6.272165,12.265979 6.4577317,12.32165 6.634021 L 12.32165 6.634021 M 13.022165 2.8716495 c -1.0716496 0.28298968,-2.5005155 0.43608245,-4.022165 0.43608245 s -2.9505155 -0.15309279,-4.022165 -0.43608245 C 3.8922682 2.5886598,3.623196 2.2917526,3.6185567 2.2360826 c 0.0046391753 -0.032474227,0.08814433 -0.13917527,0.34793815 -0.27371135 c 0.20876288 -0.11134021,0.528866 -0.23659794,1.0113401 -0.36649486 c 1.0716496 -0.28298968,2.5005155 -0.43608245,4.022165 -0.43608245 s 2.9505155 0.15309279,4.022165 0.43608245 c 0.48711342 0.12525773,0.80721647 0.25515464,1.0159794 0.36649486 c 0.25979382 0.13453609,0.34329897 0.2412371,0.34793815 0.27371135 C 14.372165 2.2917526,14.107733 2.5886598,13.022165 2.8716495 L 13.022165 2.8716495 z'/%3E%3C/svg%3E"
		},
	"description": "Feed the cat",
	"appliesTo": [
		"bpmn:UserTask"
	],
	"id": "catFoodBowl",
	"documentationRef": "https://docs.camunda.io",
	"elementType": {
		"value": "bpmn:UserTask"
	},
	"properties": [
		{
			"binding": {
				"name": "name",
				"type": "property"
			},
			"type": "String",
			"value": "Feed the cat"
		}
	]
}
```

## Fun with flags <a name="funWithFlags"></a>
<img src="./svgs/un.svg" width="100px"><img src="./svgs/eu.svg" width="100px"><img src="./svgs/de.svg" width="100px"><img src="./svgs/sc.svg" width="100px"><img src="./svgs/us.svg" width="100px">
<p>Check out the available flag icons of the world <a href="./fun-with-flags/README.md">here</a>. Copy and paste individual countries or try them all at once. You can find the original source for the flag SVGs here: <a href="https://flagicons.lipis.dev/">https://flagicons.lipis.dev/</a>


## The SVG converter utilities <a name="svgConverter"></a>
If you want to create your own icons you can use these converters to do so. Bear in mind, the simpler the SVG, the better the chances of success. SVGs using arcane transforms may return odd results until the algorithms can handle them. Also keep in mind the end result will fit into an 18x18 box and an SVG that looks great at 500x500 may not look as great at 18x18 until you zoom in. If you want to convert a single SVG use the **RescaleImage** class which can be found here:

```
src/main/java/org/svg/utilities/RescaleImage
```

It uses a static main method. The six arguments to pass into the main class are:

```
"SVG input file location" "Modeler Element Template file location" "Icon width in pixels" "Element Template ID" "Element Template Name/Description/etc" "What BPMN elements it will apply to"
```

If you have a directory of SVG icons to convert you can use the **BulkConverter** class which can be found here:

```
src/main/java/org/svg/utilities/BulkConverter
```

It also uses a static main method. The six arguments to pass into the main class are:

```
"SVG input directory" "Directory of converted SVG snippets" "Modeler Element Template file location" "Icon width in pixels" "Element Template ID" "Element Template Name/Description/etc" "What BPMN elements it will apply to" "Converted snippet directory" "Converted SVG directory"
```

The converted snippet and SVG directories are only used if you plan to add to this repository as it makes updating the readme easier. Feel free to use throwaway directories. The Bulk Converter will be refactored for more streamlined functioning in later releases.

## Using Inkscape <a name="usingInkscape"></a>
If an icon is not available here or if the converter has a hard time with a desired SVG, Inkscape can be used to manually update the SVG.

Inkscape is an open source vector graphics editor and it can be found [here](https://inkscape.org/). Download and install Inkscape. Don't worry, it's available on all platforms. Start Inkscape and open the target SVG using **File > Open**.

Change the size of the document in the **Document Properties** panel by going to **File > Document Properties** or use **Ctrl-Shift-D** and set the **Width** and **Height** properties to 18x18px:

<img src="./images/docProperties.png" width="369" height="347">

Next, manually resize the entire image by one of two ways. First, however, select everything in the diagram using **Ctrl-A**. One method is to then simply enter an X of zero, Y of zero, lock aspect ratio and enter a width or height of 18 in the top panel (see image below). Another approach is to select a corner (usually lower right) of the outermost object and while holding the **Ctrl key** (to lock aspect ratio), resize the image to fit inside the new 18x18px canvas (you may need to zoom in to make it easier). FYI this is an SVG of the flag of Bermuda.

<img src="./images/topPanel.png" width="728" height="43">

<img src="./images/resize.png" width="432" height="434">

Save your results, ideally in another file to avoid overwriting the source - **File > Save As...**. Be sure to save as a **Plain SVG** as saving it as an Inkscape SVG adds superfluous metadata. You may still need to manually edit the SVG file in a text editor to remove extraneous information.

Next, run the SVG through the 'light' URL encoder utility. While you can simply apply URL encoder on the SVG it will also encode whitespace which isn't required and will result in an unreadable SVG in the event you'd like to make manual updates. The updated SVG can be run through a 'light' URL encoding and augmentation (it adds ```data:image/svg+xml,``` to the beginning) utility which can be found here:

```
src/main/java/org/svg/utilities/LightEncodeAndAugmentSVG
```

Its sole argument is

```
location and name of updated SVG file
```

Copy and paste the encoded and augmented SVG (it will be sent to the console) into your Element Template file. Be sure to add it into the

```
"icon": "contents":
```
section of the Element Template entry, see:

```
{
	"$schema": "https://unpkg.com/@camunda/zeebe-element-templates-json-schema/resources/schema.json",
	"name": "Bermuda",
	"icon": { "contents": "data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg'...
```

Reset Modeler and it will be shown as part of the Element Template:

<img src="./images/result.png" width="515" height="347">